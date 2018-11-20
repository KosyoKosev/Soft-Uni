using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Wormtest
{
    class Wormtest
    {
        static void Main(string[] args)
        {
            var lengthWorm = long.Parse(Console.ReadLine());
            var wigthWorm = decimal.Parse(Console.ReadLine());

            var length = lengthWorm * (wigthWorm / 100);
            var lengthWormCm = lengthWorm * 100;

            var remainder = 0m;

            if (wigthWorm == 0)
            {
                
            }
            else
            {
                 remainder = lengthWormCm % wigthWorm;
            }
            if (remainder == 0)
            {
                Console.WriteLine($"{lengthWormCm * wigthWorm:F2}");
            }
            else
            {
                var procent = lengthWormCm / (wigthWorm / 100);
                Console.WriteLine($"{procent:F2}%");
            }
        }
    }
}
