const SubscriptionCard = require('../subscriptionCard')
const expect = require('chai').expect

describe("SubscriptionCard tests", function() {
    let card
    beforeEach(function () {
        card = new SubscriptionCard('Pesho', 'Petrov', '0000000')
    })

    it("It should have initialized all methods", function() {
        expect(Object.getPrototypeOf(card).hasOwnProperty('addSubscription')).to.be.equal(true)
        expect(Object.getPrototypeOf(card).hasOwnProperty('isValid')).to.be.equal(true)
        expect(Object.getPrototypeOf(card).hasOwnProperty('block')).to.be.equal(true)
        expect(Object.getPrototypeOf(card).hasOwnProperty('firstName')).to.be.equal(true)
        expect(Object.getPrototypeOf(card).hasOwnProperty('unblock')).to.be.equal(true)
        expect(Object.getPrototypeOf(card).hasOwnProperty('lastName')).to.be.equal(true)
        expect(Object.getPrototypeOf(card).hasOwnProperty('SSN')).to.be.equal(true)
    })

    it("FirtsName, LastName, SSN", function() {
        expect(card.firstName).to.be.equal('Pesho')
        expect(card.lastName).to.be.equal('Petrov')
        expect(card.SSN).to.be.equal('0000000')
        expect(card.isBlocked).to.be.equal(false)
    })

    it("block and unblock", function() {
        card.block()
        expect(card.isBlocked).to.be.equal(true)
        card.unblock()
        expect(card.isBlocked).to.be.equal(false)
    })

    it("isValid", function() {
        card.addSubscription('120', new Date('2018-04-26'), new Date('2018-10-26'))
        card.addSubscription('121', new Date('2018-04-25'), new Date('2018-10-26'))
        card.addSubscription('*', new Date('2018-04-26'), new Date('2018-10-26'))
        expect(card.isValid('120', new Date('2018-04-28'))).to.be.equal(true)
        expect(card.isValid('120', new Date('2018-04-25'))).to.be.equal(false)
        expect(card.isValid('*', new Date('2018-04-28'))).to.be.equal(true)
        expect(card.isValid('*', new Date('2018-04-25'))).to.be.equal(false)
        card.block()
        expect(card.isValid('120', new Date('2018-04-28'))).to.be.equal(false)
        expect(card.isValid('*', new Date('2018-04-28'))).to.be.equal(false)
    })

    it("isValid", function() {
        card.firstName = 'Gosho'
        card.lastName = 'Gosho'
        card.SSN = 'Gosho'
        card.isBloked = true
        expect(card.firstName).to.be.equal('Pesho')
        expect(card.lastName).to.be.equal('Petrov')
        expect(card.SSN).to.be.equal('0000000')
        expect(card.isBlocked).to.be.equal(false)
    })
});
