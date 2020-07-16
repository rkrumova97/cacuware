import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavigationComponent} from './navigation/navigation.component';
import {ErrorComponent} from './error/error.component';
import {FooterComponent} from './footer/footer.component';
import {CoreComponent} from './core/core.component';
import {CoreRoutingModule} from "./core-routing.module";


@NgModule({
  declarations: [NavigationComponent, ErrorComponent, FooterComponent, CoreComponent],
  exports: [
    FooterComponent,
    NavigationComponent,
    CoreComponent
  ],
  imports: [
    CommonModule, CoreRoutingModule
  ]
})
export class CoreModule {
}
