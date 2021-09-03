export class Product {
    // making each param public is typescript shorthand to create a public 
    // field and assign a value every time a Product is constructed
    constructor (
        public title?: string,
        public category?: string,
        public man?: string,
        public minLimit?: number,
        public productQuantity?: number
    ) {}
}
