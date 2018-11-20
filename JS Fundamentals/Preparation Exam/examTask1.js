function task1(arr) {
    let totalAmount = 0
    let bitcoinCounter = 0
    let dayBoughtFirstBitcoin = 0
    let priceForBitcoin = 11949.16
    let isBoughtBitcoin = false
    for (let i = 1; i <= arr.length; i++) {
        let currentBitcoinCounter = 0
        if (i % 3 === 0){
            arr[i - 1] -= arr[i - 1] * 0.3
        }
        totalAmount += arr[i - 1] * 67.51
        if (totalAmount - priceForBitcoin >= 0){
            if (!isBoughtBitcoin){
                dayBoughtFirstBitcoin = i
                isBoughtBitcoin = true
            }
            currentBitcoinCounter = Math.floor(totalAmount / priceForBitcoin)
            bitcoinCounter += currentBitcoinCounter
            totalAmount -= currentBitcoinCounter * priceForBitcoin
        }
    }
    console.log(`Bought bitcoins: ${bitcoinCounter}`)
    if (dayBoughtFirstBitcoin !== 0){
        console.log(`Day of the first purchased bitcoin: ${dayBoughtFirstBitcoin}`)
    }
    console.log(`Left money: ${totalAmount.toFixed(2)} lv.`)
}
task1([50, 100])