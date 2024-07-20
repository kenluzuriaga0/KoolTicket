import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideAnimations } from '@angular/platform-browser/animations';
import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { SessionInterceptor } from './core/session.interceptor';
import { provideToastr } from 'ngx-toastr';

export const appConfig: ApplicationConfig = {
  providers: [
      provideRouter(routes),
      provideAnimations(),
      provideToastr({preventDuplicates: true}), // Toastr providers
      provideHttpClient(),
      // El sesionIntercepto es una clase (FromDI), asi que es necesaria esta linea
      provideHttpClient(withInterceptorsFromDi()), 
      {provide: HTTP_INTERCEPTORS, useClass: SessionInterceptor, multi: true},
      // Esto es valido para interceptors que no son clases (const)
      // provideHttpClient(withInterceptors([SessionInterceptor])),
    ]
};
