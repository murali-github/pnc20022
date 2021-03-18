import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-transaction-modal',
  templateUrl: './transaction-modal.component.html',
  styleUrls: ['./transaction-modal.component.css']
})
export class TransactionModalComponent {
  data: any;
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

  constructor(
    public dialogRef: MatDialogRef<TransactionModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { console.log("built")
    this.data = data;
    let response = this.httpClient.post<any>("http:/localhost:8080/paymentRisk", data).pipe();
    response.subscribe(res => {
      console.log(res);
      this.responseData = res;

    });
    /*this.responseData = {trxRatingModelRequestDtos:[{category:"CURRENT_TRX",attrName:"BENEFICIARY_AC",value:"500105170123456789"},
      {category:"CURRENT_TRX",attrName:"SRC_AC",value:"123110040000109876543210"},
      {category:"CURRENT_TRX",attrName:"AMOUNT",value:"1500"},
      {category:"INTERNAL_COMPLIANCE",attrName:"HIGH_RISK_BENE_CNTRY",value:"BA,BB"},
      {category:"INTERNAL_TRX_HIST",attrName:"SRC_AVG_TRX_AMOUNT",value:"1500"},
      {category:"INTERNAL_TRX_HIST",attrName:"SRC_TOTAL_TRX_AMOUNT",value:"100000"},
      {category:"SWIFT_COMPLIANCE",attrName:"BENEFICIARY_AC_VERIFICATION",value:"LOW"},
      {category:"SWIFT_COMPLIANCE",attrName:"SRC_AC_VERIFICATION",value:"LOW"},
      {category:"SWIFT_VALIDATION",attrName:"BENEFICIARY_AC_FORMAT",value:"LOW"},
      {category:"SWIFT_VALIDATION",attrName:"SRC_AC_FORMAT",value:"LOW"}]}*/
    this.responseData.trxRatingModelRequestDtos.forEach(element => {
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



  }

  onNoClick(): void {
    this.dialogRef.close({
      status: this.data.status
    });
  }

  onApprove() {
    this.dialogRef.close({
      status: "PROCEED"
    })
  }

}
