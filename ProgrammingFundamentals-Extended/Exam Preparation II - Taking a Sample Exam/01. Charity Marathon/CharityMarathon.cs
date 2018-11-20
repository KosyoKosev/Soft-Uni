using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Charity_Marathon
{
    class CharityMarathon
    {
        static void Main(string[] args)
        {
            var daysMarathon = int.Parse(Console.ReadLine());
            var runers = int.Parse(Console.ReadLine());
            var averageLaps = int.Parse(Console.ReadLine());
            var lengthTheTrack = int.Parse(Console.ReadLine());
            var capacityTheTrack = int.Parse(Console.ReadLine());
            var moneyPerKilometer = double.Parse(Console.ReadLine());

            var maxCapacityRyners = daysMarathon * capacityTheTrack;

            if (maxCapacityRyners > runers)
            {
                maxCapacityRyners = runers;
            }

            var totalMeters = maxCapacityRyners * averageLaps * lengthTheTrack;
            var totalKilometers = totalMeters / 1000;

            var moneyRaised = moneyPerKilometer * totalKilometers;

            Console.WriteLine("Money raised: {0:0.00}", moneyRaised);
        }
    }
}
