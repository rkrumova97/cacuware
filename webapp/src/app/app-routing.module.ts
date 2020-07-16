import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        {
          path: '',
          loadChildren: () => import("./modules/security/security.module").then(m => m.SecurityModule)
        },
        {
          path: 'core',
          loadChildren: () => import("./modules/core/core.module").then(m => m.CoreModule)
        },
        {
          path: 'hr',
          loadChildren: () => import("./modules/hrms/hrms.module").then(m => m.HrmsModule)
        },
      ],
    )
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
