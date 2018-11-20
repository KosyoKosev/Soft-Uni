function daysOfLastMonth(parameters) {
    let day = parameters[0]
    let month = parameters[1]
    let year = parameters[2]

    let newYear = new Date(day,month - 1,0)
    console.log(newYear.getDate())
}
daysOfLastMonth([17, 3, 2002])