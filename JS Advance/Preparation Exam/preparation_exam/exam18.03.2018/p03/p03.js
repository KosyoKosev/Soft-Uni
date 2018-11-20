class PaymentProcessor {
    constructor(options){
        this.payments = new Map()
        this.types = ["service", "product", "other"]
        this.precision = 2
        this.setOptions(options)
    }

    registerPayment(id, name, type, value){
        if (typeof id !== 'string' || id === '' || this.payments.has(id) ||
            typeof name !== 'string' || name === '' ||
            typeof value !== 'number' || isNaN(value) ||
            !this.types.includes(type)) {
        //if (!this.types.includes(type) || id === '' || name === '' || isNaN(value) || this.payments.has(id)){
            throw new Error('invalid type')
        }else {
            this.payments.set(id, {name, type, value})
        }
    }

    deletePayment(id){
        if(!this.payments.has(id)){
            throw new Error('ID not found')
        }else {
            this.payments.delete(id)
        }
    }

    get(id){
        if(!this.payments.has(id)){
            throw new Error('ID not found')
        }else {
            let obj = this.payments.get(id)
            let value = obj['value'].toFixed(this.precision)
            let types = obj['type']
            let name = obj['name']
            return `Details about payment ID: ${id}\n- Name: ${name}\n- Type: ${types}\n- Value: ${value}
`
        }
    }

    setOptions(options){
        if (options === undefined){

        }else if (options.hasOwnProperty('types') && options.hasOwnProperty('precision')) {
            this.types = options['types']
            this.precision = options['precision']
        }else if (options.hasOwnProperty('types')){
            this.types = options['types']
        }else {
            this.precision = options['precision']
        }
    }

    toString(){
        let sum = 0
        for (let [key,value] of this.payments) {
            let obj = this.payments.get(key)
            sum += obj['value']
        }
        return `Summary:\n- Payments: ${this.payments.size}\n- Balance: ${sum.toFixed(this.precision)}
`
    }
}

// Initialize processor with default options
const generalPayments = new PaymentProcessor();
generalPayments.registerPayment('0001', 'Microchips', 'product', 15000);
generalPayments.registerPayment('01A3', 'Biopolymer', 'product', 23000);
console.log(generalPayments.toString());

// Should throw an error (invalid type)
// generalPayments.registerPayment('E028', 'Rare-earth elements', 'materials', 8000);

generalPayments.setOptions({types: ['product', 'material']});
generalPayments.registerPayment('E028', 'Rare-earth elements', 'material', 8000);
console.log(generalPayments.get('E028'));
generalPayments.registerPayment('CF15', 'Enzymes', 'material', 55000);

// // Should throw an error (ID not found)
// generalPayments.deletePayment('E027');
// // Should throw an error (ID not found)
// generalPayments.get('E027');

generalPayments.deletePayment('E028');
console.log(generalPayments.toString());

// Initialize processor with custom types
const servicePyaments = new PaymentProcessor({types: ['service']});
servicePyaments.registerPayment('01', 'HR Consultation', 'service', 3000);
servicePyaments.registerPayment('02', 'Discount', 'service', -1500);
console.log(servicePyaments.toString());

// Initialize processor with custom precision
const transactionLog = new PaymentProcessor({precision: 5});
transactionLog.registerPayment('b5af2d02-327e-4cbf', 'Interest', 'other', 0.00153);
console.log(transactionLog.toString());
