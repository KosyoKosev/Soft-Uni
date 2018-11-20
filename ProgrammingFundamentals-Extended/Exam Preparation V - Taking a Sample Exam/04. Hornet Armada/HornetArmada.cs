using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace _04.Hornet_Armada
{
    public class HornetArmy
    {
        public long Activity { get; set; }

        public string LegionName { get; set; }

        public string SoldierType { get; set; }

        public long CountSoldierType { get; set; }
    }
    class HornetArmada
    {
        static void Main(string[] args)
        {
            var sortedHornetArmy = new HashSet<HornetArmy>();
            var n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine();

                var split = input.Split(new[] {' ', '=', '-', '>', ':'}, StringSplitOptions.RemoveEmptyEntries);

                var activity = long.Parse(split[0]);
                var legionName = split[1];
                var soldierType = split[2];
                var countSoldierType = long.Parse(split[3]);

                var currentHornetArmy = new HornetArmy();

                currentHornetArmy.Activity = activity;
                currentHornetArmy.LegionName = legionName;
                currentHornetArmy.SoldierType = soldierType;
                currentHornetArmy.CountSoldierType = countSoldierType;

                if (!sortedHornetArmy.Contains(currentHornetArmy))
                {
                    sortedHornetArmy.Add(currentHornetArmy);
                }
            }
        }
    }
}
