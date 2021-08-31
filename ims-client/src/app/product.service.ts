import { Injectable } from '@angular/core';
import { Product } from './product';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private baseUrl = "http://localhost:8081/products"

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}`);
  }

  getProductByCategory(category: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/${category}`)
  }

  /* GET heroes whose name contains search term */
searchCategory(term: string): Observable<Product[]> {
  if (!term.trim()) {
    // if not search term, return empty hero array.
    return of([]);
  }
  return this.http.get<Product[]>(`${this.baseUrl}/${term}`).pipe(
    tap(x => x.length ?
       console.log(`found categories matching "${term}"`) :
       console.log(`no categories matching "${term}"`))
  );
}

constructor(
  private http: HttpClient) { }
}

