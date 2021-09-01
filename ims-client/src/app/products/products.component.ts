import { Component, OnInit } from '@angular/core';

import { ProductService } from '../product.service';
import { Product } from '../product';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Output, EventEmitter } from '@angular/core';
import { StocksService } from '../stocks.service';
import { Stocks } from '../stocks';


@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  productByCategory: Product[] = [];
  selectedCategory: string = "";
  invoiceNumber: number = 0;
  
  categorySelection(term: string) {
    this.selectedCategory = term;
    this.getCategory();
  }

  constructor(private productService: ProductService, 
              private route: ActivatedRoute,
              private location: Location,
              private stocksService: StocksService) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    this.productService.getAllProducts()
      .subscribe(products => {
        this.productByCategory = products;
      })
  }

  getCategory() {
    console.log(this.selectedCategory)
    let category = this.selectedCategory
    if (category == "") {
      this.productByCategory = this.products;
    } else {
      this.productService.getProductByCategory(category)
      .subscribe(filteredProducts => {
        this.productByCategory = filteredProducts;
      })
    }
  }

  updateProductStock(product: Product, transactionType: string): void {
    let transaction:Stocks = {
      stockId: null,
      productId: product.productId,
      transactionDate: new Date(),
      vendor: product.vendor,
      batchCode: product.batchCode,
      invoiceNum: product.invoiceNumber,
      quantity: product.quantity,
      transactionType: transactionType
    };


      // productId = products.ticket_id;
      // transactionDate = new Date();
      // vendor = "";
      // batchCode = "";
      // invoiceNum = "";
      // quantity = 1;

    // this.stocksService.addStock({ productId, transactionDate, vendor, batchCode, invoiceNum, quantity} as Stocks)
    //     .subscribe()

    // this.ticketService.addTicket({ ticketType, note, amount, "status": "pending", "employeeId": 1 } as Ticket)
    //   .subscribe(ticket => {
    //     this.tickets.push(ticket);
    //     this.errors = "";
    //     this.success = "success!"
        
    //   },
    //     error => {
    //       this.errors = error;
          
    //     }
    //   );
  }

}
