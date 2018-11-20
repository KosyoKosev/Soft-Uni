using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4.Array_Histogram
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = Console.ReadLine().Split(' ');
            var counters = new List<int>();

            for (int i = 0; i < text.Count; i++)
            {
                for (int j = 0; j < text.Count; j++)
                {
                    if (i == j)
                    {
                        continue;
                    }
                    if (text.Contains(text[j]))
                    {
                        text.RemoveAt(j);
                        (counters[j])++;
                    }
                    else
                    {
                        counters.Add(1);
                    }
                }
            }

            Console.WriteLine(string.Join(" ", text));
            Console.WriteLine(string.Join(" ", counters));
        }
    }
}
