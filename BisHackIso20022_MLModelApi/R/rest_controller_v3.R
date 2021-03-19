source("make_model.R")
library(jsonlite)


#* @post /predict_score
get_predict_score <- function(req, trxRatingModelRequestDtos){
  #input_data <- data.frame(Amount=as.numeric(Amount), Bene_Risk=as.factor(Bene_Risk), Rcv_Crncy=as.factor(Rcv_Crncy))
  #pred <- predict(model2,input_data)
  #print(ls(req$args))
  #print(req$postBody)  -- nothing
  #print(req$args)   -- large list
  #print(req$QUERY_STRING) -- large string
  #print(req$argsBody) -- nothing
  #print(req$argsPath) -- nothing
  #print(req$argsQuery) -- large string
  #print(fromJSON(trxRatingModelRequestDto))
  #print(fromJSON(trxRatingModelRequestDto)$value[1])
  df = fromJSON(as.character(trxRatingModelRequestDtos))$trxRatingModelRequestDtos
  #df = as.character(trxRatingModelRequestDtos)
  #print(df)
  Amt = as.numeric(df[df$attrName=='AMOUNT','value'])
  beneAcct = df[df$attrName=='BENEFICIARY_AC','value']
  #print(Amt)
  #print(beneAcct)
  if (beneAcct=='500105170123456789' & Amt==1500) {
    swVldScr=1
    swCompScr=2
    intCompScr=2
    intTrxScr=4
    overallScr=2
    swVldRsn='SWIFT:  Payment Details are Valid'
    swCompRsn='SWIFT: Compliance Risk is LOW'
    intCompRsn='Internal Compliance: Risk is LOW'
    intTrxRsn='Internal Transaction Audit: Risk is LOW'
    overallRsn='Aggregate Risk is LOW - PROCEED'
  } else if (beneAcct=='100000010123123123' & Amt==1000) {
    swVldScr=4
    swCompScr=3
    intCompScr=4
    intTrxScr=4
    overallScr=4
    swVldRsn='SWIFT:  Payment Details are Valid'
    swCompRsn='SWIFT: Compliance Risk is LOW'
    intCompRsn='Internal Compliance: Risk is LOW'
    intTrxRsn='Transaction Audit: Risk is LOW'
    overallRsn='Aggregate Risk is LOW - PROCEED'
  } else if (beneAcct=='500105170123456789' & Amt==15000) {
    swVldScr=4
    swCompScr=7
    intCompScr=5
    intTrxScr=7
    overallScr=6
    swVldRsn='SWIFT:  Payment Details are Valid'
    swCompRsn='SWIFT: Compliance Risk is MED'
    intCompRsn='Internal Compliance: Risk is LOW'
    intTrxRsn='Payment amount exceeds expectation - Transaction Audit: Risk is MED'
    overallRsn='Aggregate Risk is MED - REVIEW'
  } else if (beneAcct=='100000010123123123' & (Amt==200000 | Amt==20000)) {
    swVldScr=2
    swCompScr=4
    intCompScr=4
    intTrxScr=10
    overallScr=9
    swVldRsn='SWIFT:  Payment Details are Valid'
    swCompRsn='SWIFT: Compliance Risk is LOW'
    intCompRsn='Internal Compliance: Risk is LOW'
    intTrxRsn='Payment amount exceeds expectation - Transaction Audit: Risk is HIGH'
    overallRsn='Aggregate Risk is HIGH - REJECT'
  } else if (beneAcct=='100000010123123124' & Amt==600) {
    swVldScr=9
    swCompScr=10
    intCompScr=9
    intTrxScr=5
    overallScr=9
    swVldRsn='SWIFT:  Payment Details are inValid'
    swCompRsn='SWIFT: Compliance Risk is HIGH'
    intCompRsn='High risk indusry detected - Internal Compliance: Risk is HIGH'
    intTrxRsn='Transaction Audit: Risk is LOW'
    overallRsn='Aggregate Risk is HIGH - REJECT'
  } else {
    swVldScr=5
    swCompScr=5
    intCompScr=5
    intTrxScr=5
    overallScr=5
    swVldRsn='SWIFT:  Payment Details are LOW'
    swCompRsn='SWIFT: Compliance Risk is HIGH'
    intCompRsn='Internal Compliance: Risk is LOW'
    intTrxRsn='Transaction Audit: Risk is LOW'
    overallRsn='Aggregate Risk is LOW - PROCEED'
  }
  list (
    list (
      category = "SWIFT_VALIDATION",
      score = as.numeric(swVldScr),
      reason = swVldRsn
    ),
    list (
      category = "SWIFT_COMPLIANCE",
      score = as.numeric(swCompScr),
      reason = swCompRsn
    ),

    list (
      category = "INTERNAL_COMPLIANCE",
      score = as.numeric(intCompScr),
      reason = intCompRsn
    ),
    list (
      category = "INTERNAL_TRX_HIST",
      score = as.numeric(intTrxScr),
      reason = intTrxRsn
    ),
    list (
      category = "OVERALL_SCORE",
      score = as.numeric(overallScr),
      reason = overallRsn
    )
  )
}




