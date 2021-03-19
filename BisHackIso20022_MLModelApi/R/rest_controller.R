
source("make_model.R")


#* @get /predict_score
get_predict_score <- function(req, trxRatingModelRequestDtos){
  #Amount <- as.numeric(width)
  #input_data <- data.frame(Amount=as.numeric(Amount), Bene_Risk=as.factor(Bene_Risk), Rcv_Crncy=as.factor(Rcv_Crncy))
  #predict(model2,input_data)
  df = fromJSON(trxRatingModelRequestDtos)
  print(df)
}