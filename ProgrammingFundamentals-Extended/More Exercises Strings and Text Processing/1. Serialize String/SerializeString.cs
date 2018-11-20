using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Serialize_String
{
    class SerializeString
    {
        static void Main(string[] args)
        {
            var symbols = new HashSet<char>();
            var indexs = new List<int>();

            var input = Console.ReadLine();

            for (int i = 0; i < input.Length; i++)
            {
                symbols.Add(input[i]);
                
            }

            foreach (char symbol in symbols)
            {
                for (int j = 0; j < input.Length; j++)
                {
                    if (symbol.Equals(input[j]))
                    {
                        indexs.Add(j);
                    }
                }

                Console.WriteLine($"{symbol}:{string.Join("/",indexs)}");
                
                indexs.Clear();
            }

        }
    }
}
