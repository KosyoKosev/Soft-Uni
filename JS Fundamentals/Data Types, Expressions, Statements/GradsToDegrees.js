function convertGradsToDegrees(grads) {
    grads = grads % 400
    let degrees = (grads * 0.9)
    console.log(degrees >= 0 ? degrees : 360 + degrees)
}
convertGradsToDegrees(-50)