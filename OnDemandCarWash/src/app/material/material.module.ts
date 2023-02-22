import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button'
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
const MaterialComponents =[
  MatButtonModule,
  MatCardModule,
  MatIconModule,
  MatListModule,
  MatFormFieldModule,
  MatSelectModule,
  MatInputModule,
  MatMenuModule
];
@NgModule({
  
  imports: [
   MaterialComponents
  ],
  exports:[MaterialComponents]
})
export class MaterialModule { }
