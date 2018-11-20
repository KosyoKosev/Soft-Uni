using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ununion_Lists
{
    class UnunionLists
    {
        static void Main(string[] args)
        {
            var primalList = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                var subordinate = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

                for (int j = 0; j < subordinate.Count; j++)
                {
                    if (primalList.Contains(subordinate[j]))
                    {
                        primalList.Remove(subordinate[j]);
                    }
                    else
                    {
                        primalList.Add(subordinate[j]);
                    }
                }
            }

            primalList.Sort();
            Console.WriteLine(string.Join(" ",primalList));
        }
    }
}
