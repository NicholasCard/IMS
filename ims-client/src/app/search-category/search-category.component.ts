import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-category',
  templateUrl: './search-category.component.html',
  styleUrls: ['./search-category.component.css']
})
export class SearchCategoryComponent implements OnInit {

  products$!: Observable<Product[]>;
  
  private searchTerms = new Subject<string>();
  
  @Output() newCategoryEvent = new EventEmitter<string>();

  
  constructor(private productService: ProductService, 
              private route: ActivatedRoute,
              private location: Location) { }


  

  ngOnInit(): void {
    this.products$ = this.searchTerms.pipe(
      
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.productService.searchCategory(term)),

    )
  }

  search(term: string): void {
    this.searchTerms.next(term);
  }
  
selectCategory(term: string): void {
  this.searchTerms.next(term);
  this.newCategoryEvent.emit(term)
}

}
