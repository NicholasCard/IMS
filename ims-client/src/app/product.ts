import { IProduct } from "./iproduct";

export class Product implements IProduct{
    // making each param public is typescript shorthand to create a public 
    // field and assign a value every time a Product is constructed
    productId: number;
    title: string;
    category: string;
    man: string;
    minLimit: number;
    productQuantity: number;




    constructor();

    constructor (
        productId?: number,
        title?: string,
        category?: string,
        man?: string,
        minLimit?: number,
        productQuantity?: number
    ) {
        this.productId = productId || 0;
        this.title = title || "";
        this.category = category || "";
        this.man = man || "";
        this.minLimit = minLimit || 0;
        this.productQuantity = productQuantity || 0;
    }

}

