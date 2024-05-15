import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from './services/authentication.service';
import { map } from 'rxjs';

export const authGuard: CanActivateFn = (route, state) => {
  const authService: AuthenticationService = inject(AuthenticationService);
  const router: Router = inject(Router);
  
  return authService.isLoggedIn$.pipe(
    map((status) => {
      if (status) {
        return true;
      }

    return router.createUrlTree(['/login']);
    })
  );
};
