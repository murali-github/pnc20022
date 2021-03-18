import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';

import { TransactionModalComponent } from './modals/transaction-modal/transaction-modal.component';
import * as uuid from 'uuid';



const TRANSACTION_DATA = [
  {institutionName:"ING-DIBA AG (RETAIL BANKING)", amount: "1500", status: "PROCEED", benCountry: "DE",
  creditorAccount: "500105170123456789", debitorAccount:"123110040000109876543210", sourceCountry: "PO"},
  {institutionName: "Black Forest Bank", creditorAccount: "100000010123123123", amount: "1000", benCountry: "DE",
  debitorAccount: "123110040000109876543210", status: "PROCEED", sourceCountry: "PO"},
  {institutionName: "ING-DIBA AG (RETAIL BANKING)", amount: "15000", status: "REVIEW", benCountry: "DE",
  creditorAccount: "500105170123456789", debitorAccount: "123110040000109876543210", sourceCountry: "PO"},
  {institutionName: "Black Forest Bank", amount: "200000", status: "REJECT", benCountry: "DE",
  creditorAccount: "100000010123123123", debitorAccount: "123110040000109876543210", sourceCountry: "PO"},
  {institutionName: "Black Forest Bank", amount: "600", status: "REJECT", benCountry: "DE",
  creditorAccount: "100000010123123124", debitorAccount: "123110040000109876543210", sourceCountry: "PO"}
];


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  formData = this.formBuilder.group({
    institutionName: '',
    creditorAccount: '',
    creditorName: '',
    amount: '',
    debitorAccount: ''
  })

  tableData = TRANSACTION_DATA
  columnsToDisplay: string[] = ["debitorAccount", "sourceCountry", "creditorAccount", "institutionName", "benCountry", "amount", "status"]

  constructor (private formBuilder: FormBuilder, public httpClient: HttpClient, public dialog: MatDialog
    ) {}

    onSubmit(): void {
      this.formData.value.uuid = "aye2yes-" + uuid.v4();
      console.log(this.formData);

      let response = this.httpClient.post<any>("http:/localhost:8080/paymentRisk", this.formData.value).pipe(

      )
      response.subscribe(res => {
        console.log(res);
      });
    }

    onClick(row) {
      console.log(row)
      const dialogRef = this.dialog.open(TransactionModalComponent, {
      width: '75%',
      data: row
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed', result);
      row.status = result.status;

    });
  }

}
