import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable()
export class SessionInterceptor implements HttpInterceptor {

  constructor(private _authService: AuthService, private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = this._authService.getToken();
    const authReq = req.clone({
      headers: req.headers.set('Authorization', `Bearer ${authToken}`)
    });
    return next.handle(authReq).pipe(
      catchError((err: any) => {
        if (err instanceof HttpErrorResponse) {
          // Handle HTTP errors
            this._authService.logout();
            this.router.navigate(['login']);
        } else {
          console.error('An error occurred:', err); // Handle non-HTTP errors
        }

        return throwError(() => err);
      })
    );;
  }
}

//TODO: Implementar un Loading Spinnig Interceptor en un const. 
// Read later: https://dev.to/bytebantz/angulars-17-interceptors-complete-tutorial-220k

// export const loadingSpinnerInterceptor: HttpInterceptorFn = (req, next) => {
//   const loadingService = new LoadingService(); // Instantiate the loading service
//   loadingService.showLoadingSpinner(); // Show loading spinner UI element

//   return next(req).pipe(
//     finalize(() => {
//       loadingService.hideLoadingSpinner(); // Hide loading spinner UI element
//     })
//   );
// };

