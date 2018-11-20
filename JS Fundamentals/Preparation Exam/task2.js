function task2(arr) {
    let numbers = []
    for (var i = 0; i < arr.length; i++) {

        if (typeof arr[i] === 'number'){
            numbers.push(arr[i])
        }else {
            if (numbers.length > 1){
                let num1 = numbers.pop()
                let num2 = numbers.pop()
                let sum = 0
                switch (arr[i]){
                    case "+": sum = num1 + num2; break
                    case "-": sum = num2 - num1; break
                    case "/": sum = num2 / num1; break
                    case "*": sum = num1 * num2; break
                }
                numbers.push(sum)
            }else {
                console.log('Error: not enough operands!');
                return
            }
        }
    }
    if (numbers.length === 1){
        console.log(numbers[0])
    }else {
        console.log('Error: too many operands!')
    }
}
task2([31,
    2,
    '+',
    11,
    '/']
)