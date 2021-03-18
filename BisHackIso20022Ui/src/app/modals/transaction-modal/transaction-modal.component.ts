import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-transaction-modal',
  templateUrl: './transaction-modal.component.html',
  styleUrls: ['./transaction-modal.component.css']
})
export class TransactionModalComponent {
  transactionData: any;
  responseData: any;

  currentTrxBen;
  currentTrxSrc;
  currentTrxAmm;

  internalComplianceHRBC;

  internalTranHistSATA;
  internalTranHistSTTA;

  swiftComplianceBAV;
  swiftComplianceSAV;

  swiftValidationBAF;
  swiftValidationSAF;

  swiftValidationScore;
  swiftComplianceScore;
  internalComplianceScore;
  internalTranHistScore;
  overallScore;

  riskRecommendation;

  constructor(
    public dialogRef: MatDialogRef<TransactionModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, public httpClient: HttpClient) { console.log("built")
    this.transactionData = data;
    let response = this.httpClient.post<any>("http://localhost:8080/paymentRisk", data).pipe();
    response.subscribe(res => {
      console.log(res);
      this.responseData = res;

      this.riskRecommendation = this.responseData.riskRecommendation;
      this.responseData.mlModelInput.trxRatingModelRequestDtos.forEach(element => {
        if(element.category == "CURRENT_TRX" && element.attrName == "BENEFICIARY_AC")
        {
          this.currentTrxBen = element.value;
        }
        if(element.category == "CURRENT_TRX" && element.attrName == "SRC_AC")
        {
          this.currentTrxSrc = element.value;
        }
        if(element.category == "CURRENT_TRX" && element.attrName == "AMOUNT")
        {
          this.currentTrxAmm = element.value;
        }
        if(element.category == "INTERNAL_COMPLIANCE" && element.attrName == "HIGH_RISK_BENE_CNTRY")
        {
          this.internalComplianceHRBC = element.value;
        }
        if(element.category == "INTERNAL_TRX_HIST" && element.attrName == "SRC_AVG_TRX_AMOUNT")
        {
          this.internalTranHistSATA = element.value;
        }
        if(element.category == "INTERNAL_TRX_HIST" && element.attrName == "SRC_TOTAL_TRX_AMOUNT")
        {
          this.internalTranHistSTTA = element.value;
        }
        if(element.category == "SWIFT_COMPLIANCE" && element.attrName == "BENEFICIARY_AC_VERIFICATION")
        {
          this.swiftComplianceBAV = element.value;
        }
        if(element.category == "SWIFT_COMPLIANCE" && element.attrName == "SRC_AC_VERIFICATION")
        {
          this.swiftComplianceSAV = element.value;
        }
        if(element.category == "SWIFT_VALIDATION" && element.attrName == "BENEFICIARY_AC_FORMAT")
        {
          this.swiftValidationBAF = element.value;
        }
        if(element.category == "SWIFT_VALIDATION" && element.attrName == "SRC_AC_FORMAT")
        {
          this.swiftValidationSAF = element.value;
        }

      });

      this.responseData.riskRatingDetails.forEach(element => {
        if(element.category == "SWIFT_VALIDATION")
        {
          this.swiftValidationScore = element.score;
        }
        if(element.category == "SWIFT_COMPLIANCE")
        {
          this.swiftComplianceScore = element.score;
        }
        if(element.category == "INTERNAL_COMPLIANCE")
        {
          this.internalComplianceScore = element.score;
        }
        if(element.category == "INTERNAL_TRX_HIST")
        {
          this.internalTranHistScore = element.score;
        }
        if(element.category == "OVERALL_SCORE")
        {
          this.overallScore = element.score;
        }
      });

    });





  }

  onNoClick(): void {
    this.dialogRef.close({
      status: this.transactionData.status
    });
  }

  onApprove() {
    this.dialogRef.close({
      status: "PROCEED"
    })
  }

}
