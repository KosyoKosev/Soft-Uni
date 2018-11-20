function assignProperties(parameters) {

    return `{
  ${parameters[0]}: '${parameters[1]}',
  ${parameters[2]}: '${parameters[3]}',
  ${parameters[4]}: '${parameters[5]}'
}
`
}
console.log(assignProperties(['name', 'Pesho', 'age', '23', 'gender', 'male']))