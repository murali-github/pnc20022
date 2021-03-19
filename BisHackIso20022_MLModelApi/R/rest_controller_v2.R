
source("make_model.R")


#* @post /predict_score
get_predict_score <- function(req, trxRatingModelRequestDtos){
  #input_data <- data.frame(Amount=as.numeric(Amount), Bene_Risk=as.factor(Bene_Risk), Rcv_Crncy=as.factor(Rcv_Crncy))
  #pred <- predict(model2,input_data)
  # list (
  #   list (
  #     category = "SWIFT_VALIDATION",
  #     score = as.numeric(5)
  #   ),
  #   list (
  #     category = "SWIFT_COMPLIANCE",
  #     score = as.numeric(6)
  #   ),
  #   
  #   list (
  #     category = "INTERNAL_COMPLIANCE",
  #     score = as.numeric(7)
  #     ),
  #   list (
  #     category = "INTERNAL_TRX_HIST",
  #     score = as.numeric(4)
  #     ),
  #   list (
  #     category = "OVERALL_SCORE",
  #     score = as.numeric(5)
  #   )
  # )
  #df = fromJSON(trxRatingModelRequestDtos)
  trxRatingModelRequestDtos
  #df = trxRatingModelRequestDtos
  #print(df)
  #Amt = as.numeric(df[df$attrName=='AMOUNT','value'])
  #beneAcct = df[df$attrName=='BENEFICIARY_AC','value']
  #print(Amt)
}

