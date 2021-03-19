
#dataset <- iris
# create the model
#model <- lm(Petal.Length ~ Petal.Width, data = dataset)


# example: run the model once
#input_data <- data.frame(Petal.Width=1)
#predict(model,input_data)



df <- read.csv("mock_input.csv",header=TRUE)
df$Orig_Risk <- as.factor(df$Orig_Risk)
df$Bene_Risk <- as.factor(df$Bene_Risk)
df$Rcv_Crncy <- as.factor(df$Rcv_Crncy)

model2 <- lm(Risk_Rtg~Amount+Bene_Risk+Rcv_Crncy , data=df)

#input_data <- df[1,]
#pred <-predict(model2,input_data)
#as.numeric(pred)
