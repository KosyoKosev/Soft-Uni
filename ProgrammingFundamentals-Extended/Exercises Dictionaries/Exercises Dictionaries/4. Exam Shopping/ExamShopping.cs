using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4.Exam_Shopping
{
    class ExamShopping
    {
        static void Main(string[] args)
        {
            var stocks = new SortedDictionary<string , int>();

            var key = "";
            var value = 0;
            var command = "";

            var input = Console.ReadLine();

            while (input != "exam time")
            {
                string[] split = input.Split(' ');

                if (split.Length > 2)
                {
                    command = split[0];

                    switch (command)
                    {
                        case "stock":

                            key = split[1];
                            value = int.Parse(split[2]);


                            if (!stocks.ContainsKey(key))
                            {
                                stocks.Add(key, 0);

                            }
                            
                                stocks[key] += value;
                            
                        break;

                        case "buy":
                            key = split[1];
                            value = int.Parse(split[2]);

                            if (!stocks.ContainsKey(key))
                            {
                                Console.WriteLine($"{key} doesn't exist");
                               
                            }
                            else
                            {
                                if (stocks[key] == 0)
                                {
                                    Console.WriteLine($"{key} out of stock");
                                }
                                else
                                {
                                    stocks[key] = Math.Max(stocks[key] - value, 0);
                                }
                            }

                            
                            break;
                    }
                    
                }

                input = Console.ReadLine();
            }

            
            foreach (var stock in stocks)
            {
                if (stock.Value != 0)
                {
                    Console.WriteLine($"{stock.Key} -> {stock.Value}");
                }
                
            }
        }
    }
}
