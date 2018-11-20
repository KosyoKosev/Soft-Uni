function bitcoins(arr) {
    let bitcoinCounter = 0
    let dayOfPurchasedBitcoin = 0
    let totalLv = 0

    for (let i = 0; i < arr.length; i++) {
        if ((i + 1) % 3 === 0){
            arr[i] *= 0.7
        }
        totalLv += arr[i] * 67.51
        if (totalLv >= 11949.16){
            bitcoinCounter += parseInt(totalLv / 11949.16)
            if (dayOfPurchasedBitcoin === 0){
                dayOfPurchasedBitcoin = i +1
            }
            totalLv %= 11949.16
        }
    }

    console.log(`Bought bitcoins: ${bitcoinCounter}`)
    if (dayOfPurchasedBitcoin > 0){
        console.log(`Day of the first purchased bitcoin: ${dayOfPurchasedBitcoin}`)
    }
    console.log(`Left money: ${totalLv.toFixed(2)} lv.`)
}

bitcoins([100, 200, 300])
// 11949.16 lv.
// 67.51 lv.
