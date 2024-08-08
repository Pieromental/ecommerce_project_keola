import { Component, HostListener, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { ProductService, Product } from '../product.service';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-catalog',
  templateUrl: './product-catalog.component.html',
  styleUrls: ['./product-catalog.component.css'],
  standalone: true,
  imports: [CommonModule, MatCardModule, MatGridListModule]
})
export class ProductCatalogComponent implements OnInit {
  products: Product[] = [];
  cols: number = 4;

  constructor(private productService: ProductService, @Inject(PLATFORM_ID) private platformId: any) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe((data: Product[]) => {
      this.products = data;
    });

    if (isPlatformBrowser(this.platformId)) {
      this.updateGridCols(window.innerWidth);
    }
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: Event) {
    if (isPlatformBrowser(this.platformId)) {
      const target = event.target as Window;
      this.updateGridCols(target.innerWidth);
    }
  }

  updateGridCols(width: number) {
    if (width < 600) {
      this.cols = 1;
    } else if (width < 960) {
      this.cols = 2;
    } else if (width < 1280) {
      this.cols = 3;
    } else {
      this.cols = 4;
    }
  }
}
