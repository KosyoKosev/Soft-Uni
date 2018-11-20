class LineManager {
    constructor(arrOfStops){
        this.stops = []
        this._atDepot = false
        this._currentDelay = 0
        this.timeOfCoures = 0
        this.counterStops = 0
        this._nextStopName = ''
        this._setInput(arrOfStops)


    }

    get atDepot(){
        return this._atDepot
    }

    get nextStopName(){
        return this.counterStops !== this.stops.length - 1? this._nextStopName : 'At depot.'
    }

    get currentDelay(){
        return this._currentDelay
    }

    arriveAtStop(minutes){
        if (minutes < 0){
            throw new Error('minutes cannot be negative')
        }
        if (this._atDepot === true){
            throw new Error('last stop reached')
        }
        if (this.stops.length - 2 === this.counterStops){
            this._atDepot = true
            this._currentDelay += minutes - this.stops[this.counterStops].timeToNext
            this.timeOfCoures += minutes
            this.counterStops++
            this._setNextName()
            return false
        }

        this._currentDelay += minutes - this.stops[this.counterStops].timeToNext
        this.timeOfCoures += minutes
        this.counterStops++
        this._setNextName()
        return true
    }

    _setInput(arr){
        for (let obj of arr) {
            if(typeof obj === 'object' && typeof obj.name === 'string' && typeof obj.timeToNext === 'number'){
                if (obj.name !== '' && obj.timeToNext >= 0){
                    this.stops.push(obj)
                }else {
                    throw new Error('Incorrect data!!!')
                }
            }
        }
        this._setNextName()
    }

    _setNextName(){

        if (this.counterStops < this.stops.length - 1) {
            this._nextStopName = this.stops[this.counterStops + 1].name
        }

    }

    toString(){
        let result = ''
        if (this.counterStops === this.stops.length - 1){
            result =`Line summary\n- Course completed\n- Stops covered: ${this.counterStops}\n- Time on course: ${this.timeOfCoures} minutes\n- Delay: ${this._currentDelay} minutes`
        }else {
            result =`Line summary\n- Next stop: ${this._nextStopName}\n- Stops covered: ${this.counterStops}\n- Time on course: ${this.timeOfCoures} minutes\n- Delay: ${this._currentDelay} minutes`
        }
        return result
    }
}

const mgr = new LineManager([
    {name: 'Depot', timeToNext: 4},
    {name: 'Romanian Embassy', timeToNext: 2},
    {name: 'TV Tower', timeToNext: 3},
    {name: 'Interpred', timeToNext: 4},
    {name: 'Dianabad', timeToNext: 2},
    {name: 'Depot', timeToNext: 0},
]);
console.log(mgr.toString())
mgr.arriveAtStop(3);
console.log(mgr.toString())
mgr.arriveAtStop(4);
mgr.arriveAtStop(4);
mgr.arriveAtStop(4);
mgr.arriveAtStop(4);
console.log(mgr.toString())

// const man = new LineManager([
//     {name: 'Depot', timeToNext: 4},
//     {name: 'Romanian Embassy', timeToNext: 2},
//     {name: 'TV Tower', timeToNext: 3},
//     {name: 'Interpred', timeToNext: 4},
//     {name: 'Dianabad', timeToNext: 2},
//     {name: 'Depot', timeToNext: 0},
// ]);
// const mgr = new LineManager([
//     {name: 'Depot', timeToNext: 4},
//     {name: 'Romanian Embassy', timeToNext: 2},
//     {name: 'TV Tower', timeToNext: 3},
//     {name: 'Interpred', timeToNext: 4},
//     {name: 'Dianabad', timeToNext: 2},
//     {name: 'Depot', timeToNext: 0},
// ]);
// mgr.arriveAtStop(1);
// mgr.arriveAtStop(1);
// mgr.arriveAtStop(1);
// mgr.arriveAtStop(1);
// mgr.arriveAtStop(1);
// mgr.arriveAtStop(1);

//Travel through all the stops until the bus is at depot
// while(man.atDepot === false) {
//     console.log(man.toString());
//     man.arriveAtStop(4);
// }
//
// console.log(man.toString());

// // Should throw an Error (minutes cannot be negative)
// man.arriveAtStop(-4);
// // Should throw an Error (last stop reached)
// man.arriveAtStop(4);
//
// // Should throw an Error at initialization
// const wrong = new LineManager([
//     { name: 'Stop', timeToNext: { wrong: 'Should be a number'} }
// ]);
