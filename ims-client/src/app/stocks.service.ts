import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stocks } from './stocks';

@Injectable({
  providedIn: 'root'
})
export class StocksService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  private baseUrl = "http://localhost:8081/stocks"

  constructor(
    private http: HttpClient) { }

  updateProductStock(stock: Stocks): Observable<Stocks> {
    return this.http.post<Stocks>(this.baseUrl, stock, this.httpOptions);
  }
  
  // addTicket(ticket: Ticket): Observable<Ticket> {
  //   return this.http.post<Ticket>(this.baseUrl, ticket, this.httpOptions);
  // }
}
