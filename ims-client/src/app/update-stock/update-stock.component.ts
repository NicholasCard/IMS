import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { StocksService } from '../stocks.service';
import { Product } from '../product';
import { Stocks } from '../stocks';

@Component({
  selector: 'app-update-stock',
  templateUrl: './update-stock.component.html',
  styleUrls: ['./update-stock.component.css']
})
export class UpdateStockComponent implements OnInit {

  products: Product[] = [];
  productByCategory: Product[] = [];
  selectedCategory: string = "";
  invoiceNumber: number = 0;
  errorMessage: string = "";

  constructor( 
    private route: ActivatedRoute,
    private location: Location,
    private stocksService: StocksService) { }

  ngOnInit(): void {
  }

  updateProductStock(product: Product, transactionType: string): void {

    //this should all be declared when the parent component hands it over 
    //or not at all since it should be making all this from the input
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
//i get this part but i may refactor 

    if (transaction.transactionType == "OUT" && transaction.quantity > product.productQuantity) {
      this.errorMessage = "Error: Insufficient quantity!"
    } else {
      this.errorMessage = "";
      this.stocksService.updateProductStock(transaction)
        .subscribe(p => {
          this.productByCategory.forEach(pr => {
            if (pr.productId == p.productId) {
              pr.productQuantity = p.productQuantity;
              pr.quantity = 0;
              pr.batchCode = "";
              pr.invoiceNumber = "";
              pr.vendor = "";
            }
          })
        });
    }
  }
  
}
