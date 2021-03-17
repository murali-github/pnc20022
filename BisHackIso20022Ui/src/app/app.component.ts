import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import * as uuid from 'uuid';

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

  constructor (private formBuilder: FormBuilder, public httpClient: HttpClient
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

}
