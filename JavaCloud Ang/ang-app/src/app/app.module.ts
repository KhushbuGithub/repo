import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './Home/Home.component';
import { WelcomeComponent } from './Welcome/welcome.component';
import { ReusableComponent } from './Reusable/reusable.component';
import { RouterModule} from '@angular/router';
import { AboutHomeComponent } from './about-home/about-home.component';
import { AboutComponent } from './about/about.component';
import { LocationComponent } from './location/location.component';
import { ContactComponent } from './contact/contact.component';
import { DataBindingComponent } from './data-binding/data-binding.component';
import { TwoWayComponent } from './two-way/two-way.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { DirectiveComponent } from './directive/directive.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { AddUsersComponent } from './add-users/add-users.component';
import { DisplayUsersComponent } from './display-users/display-users.component';
import { TemplateComponent } from './template/template.component';
import { TemplateRegisterComponent } from './template-register/template-register.component';
import { ReactiveComponent } from './reactive/reactive.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    WelcomeComponent,
    ReusableComponent,
    AboutHomeComponent,
    AboutComponent,
    LocationComponent,
    ContactComponent,
    DataBindingComponent,
    TwoWayComponent,
    DirectiveComponent,
    UserDetailsComponent,
    AddUsersComponent,
    DisplayUsersComponent,
    TemplateComponent,
    TemplateRegisterComponent,
    ReactiveComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path:'',component:WelcomeComponent},
      {path :'reusable',component:ReusableComponent},
      {path:'about-home',component:AboutHomeComponent,
      children:[
        {path:'about',component:AboutComponent},
        {path:'loaction', component:LocationComponent},
        {path:'contact',component:ContactComponent}
      ]},
      {path:'data-binding',component:DataBindingComponent},
      {path:'twoway', component:TwoWayComponent},
      {path:'directives',component:DirectiveComponent},
      {path:'userdetails',component:UserDetailsComponent},
      {path:'template',component:TemplateComponent},
      {path:'register',component:TemplateRegisterComponent},
      {path:'reactive',component:ReactiveComponent}
    ]),
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
