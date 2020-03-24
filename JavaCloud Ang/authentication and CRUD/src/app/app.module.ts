import { AuthGuard } from './auth.guard';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ProductsComponent } from './products/products.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';

import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    AddProductComponent,
    UpdateProductComponent,
    ProductsComponent,
    HomeComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent, canActivate: [AuthGuard], data: { expectedRole: ['user'] } },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'products', component: ProductsComponent, canActivate: [AuthGuard] , data: { expectedRole: ['admin'] }},
      { path: 'add-product', component: AddProductComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } },
      { path: 'update-product', component: UpdateProductComponent, canActivate: [AuthGuard], data: { expectedRole: ['admin'] } }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
