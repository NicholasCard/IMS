export interface Transaction {
    stock_id: number;
    product_id: number;
    transactionDate: Date;
    vendor: string;
    batchCode: string;
    invoiceNum: number;
    quantity: number;
    transactionType: string;
}