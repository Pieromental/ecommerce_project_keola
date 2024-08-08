import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../enviroment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = environment.apiUrl + '/productos';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<{ data: Product[] }>(this.apiUrl)
      .pipe(
        map(response => response.data)  // Extrae el array de productos
      );
  }
}

export interface Product {
  id: number;
  title: string;
  description: string;
  price: number;
  category:string;
  thumbnail: string;
}
