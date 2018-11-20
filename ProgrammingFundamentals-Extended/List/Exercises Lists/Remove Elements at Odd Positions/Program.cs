using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Remove_Elements_at_Odd_Positions
{
    class Program
    {
        static void Main(string[] args)
        {
            var text = Console.ReadLine().Split(' ').ToList();

            var result = new List<string>();

            for (int i = 0; i < text.Count ; i++)
            {
                if (i % 2 != 0)
                {
                    result.Add(text[i]);
                }
                
            }

            foreach (var word in result)
            {
                Console.Write(word);
            }

            Console.WriteLine();

        }
    }
}
