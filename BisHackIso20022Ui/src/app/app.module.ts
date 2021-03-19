import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { MatTableModule } from '@angular/material/table'
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TransactionModalComponent } from './modals/transaction-modal/transaction-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    TransactionModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatProgressSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [TransactionModalComponent]
})
export class AppModule { }
