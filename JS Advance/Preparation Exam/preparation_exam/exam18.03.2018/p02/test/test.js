const PaymentPackage = require('../paymentPackage')
const expect = require('chai').expect

describe("PaymentPackage", function() {
    let paymentPackage

    beforeEach(function () {
        paymentPackage = new PaymentPackage('test', 50)
    })
    it("toString", function() {
        expect(paymentPackage.toString()).to.be.equal('Package: test\n- Value (excl. VAT): 50\n- Value (VAT 20%): 60')
    })

    it("toString", function() {
        paymentPackage.active = false
        expect(paymentPackage.toString()).to.be.equal('Package: test (inactive)\n- Value (excl. VAT): 50\n- Value (VAT 20%): 60')
    })

    it("get Name", function() {
        expect(paymentPackage.name).to.be.equal('test')
    })

    it("set Name with incorect name", function() {
        expect(() => {paymentPackage.name(5)}).to.throw(Error)
        expect(() => {paymentPackage.name()}).to.throw(Error)
        paymentPackage.name = 'Gosho'
        expect(paymentPackage.name).to.be.equal('Gosho')
    })

    it("property", function() {
        expect(Object.getPrototypeOf(paymentPackage).hasOwnProperty('name')).to.be.equal(true)
        expect(Object.getPrototypeOf(paymentPackage).hasOwnProperty('value')).to.be.equal(true)
        expect(Object.getPrototypeOf(paymentPackage).hasOwnProperty('VAT')).to.be.equal(true)
        expect(Object.getPrototypeOf(paymentPackage).hasOwnProperty('active')).to.be.equal(true)
        expect(Object.getPrototypeOf(paymentPackage).hasOwnProperty('toString')).to.be.equal(true)
    })

    it("get value", function() {
        expect(paymentPackage.value).to.be.equal(50)
    })

    it("set value", function() {
        expect(() => {paymentPackage.value(-1)}).to.throw(Error)
        expect(() => {paymentPackage.value('test')}).to.throw(Error)
        paymentPackage.value = 5
        expect(paymentPackage.value).to.be.equal(5)
    })

    it("get VAT", function() {
        expect(paymentPackage.VAT).to.be.equal(20)
    })

    it("set VAT", function() {
        expect(() => {paymentPackage.VAT(-1)}).to.throw(Error)
        expect(() => {paymentPackage.VAT('test')}).to.throw(Error)
        paymentPackage.VAT = 5
        expect(paymentPackage.VAT).to.be.equal(5)
    })

    it("get active", function() {
        expect(paymentPackage.active).to.be.equal(true)
    })

    it("set active", function() {
        expect(() => {paymentPackage.active(-1)}).to.throw(Error)
        paymentPackage.active = false
        expect(paymentPackage.active).to.be.equal(false)
    })

    it("new object", function() {
        expect(paymentPackage.name).to.be.equal('test')
        expect(paymentPackage.value).to.be.equal(50)
        expect(paymentPackage.VAT).to.be.equal(20)
        expect(paymentPackage.active).to.be.equal(true)
    })
})
