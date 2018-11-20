function moviePrices(parameters) {
    let title = parameters[0].toLowerCase()
    let day = parameters[1].toLowerCase()

    switch (title){
        case 'the godfather':
            switch (day){
                case 'monday':
                    console.log(12)
                    break
                case 'tuesday':
                    console.log(10)
                    break
                case 'wednesday':
                    console.log(15)
                    break
                case 'thursday':
                    console.log(12.50)
                    break
                case 'friday':
                    console.log(15)
                    break
                case 'saturday':
                    console.log(25)
                    break
                case 'sunday':
                    console.log(30)
                    break
            }
            break
        case "schindler's list":
            switch (day) {
                case 'monday':
                    console.log(8.50)
                    break
                case 'tuesday':
                    console.log(8.50)
                    break
                case 'wednesday':
                    console.log(8.50)
                    break
                case 'thursday':
                    console.log(8.50)
                    break
                case 'friday':
                    console.log(8.50)
                    break
                case 'saturday':
                    console.log(15)
                    break
                case 'sunday':
                    console.log(15)
                    break
            }
            break
        case 'sasablanca':
            switch (day) {
                case 'monday':
                    console.log(8)
                    break
                case 'tuesday':
                    console.log(8)
                    break
                case 'wednesday':
                    console.log(8)
                    break
                case 'thursday':
                    console.log(8)
                    break
                case 'friday':
                    console.log(8)
                    break
                case 'saturday':
                    console.log(10)
                    break
                case 'sunday':
                    console.log(10)
                    break
            }
            break
        case 'the wizard of oz':
            switch (day) {
                case 'monday':
                    console.log(10)
                    break
                case 'tuesday':
                    console.log(10)
                    break
                case 'wednesday':
                    console.log(10)
                    break
                case 'thursday':
                    console.log(10)
                    break
                case 'friday':
                    console.log(10)
                    break
                case 'saturday':
                    console.log(15)
                    break
                case 'sunday':
                    console.log(15)
                    break
            }
            break
        default:
            console.log('error')
    }
}
moviePrices(['the Godfather', 'friday'])