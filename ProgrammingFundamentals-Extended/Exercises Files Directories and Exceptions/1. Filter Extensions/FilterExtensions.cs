using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace _1.Filter_Extensions
{
    class FilterExtensions
    {
        static void Main(string[] args)
        {
            string[] files = Directory.GetFiles("input");

            var filter = Console.ReadLine();

            foreach (string file in files)
            {
                if (file.Contains(filter))
                {
                    Console.WriteLine(file.Replace("input\\",""));
                }
            }
        }
    }
}
