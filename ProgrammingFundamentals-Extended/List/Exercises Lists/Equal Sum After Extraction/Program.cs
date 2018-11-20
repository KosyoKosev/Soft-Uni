using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Equal_Sum_After_Extraction
{
    class Program
    {
        static void Main(string[] args)
        {
            var firstList = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            var secondList = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            if (firstList.Count > secondList.Count)
            {
                for (int i = 0; i < secondList.Count; i++)
                {
                    if (firstList.Contains(secondList[i]))
                    {
                        firstList.Remove(secondList[i]);
                    }
                }
            }
            else
            {
                for (int i = 0; i < firstList.Count; i++)
                {
                    if (secondList.Contains(firstList[i]))
                    {
                        secondList.Remove(firstList[i]);
                    }
                }
            }

            var sumFirstList = 0;
            var sumSecondList = 0;

            foreach (var number in firstList)
            {
                sumFirstList += number;
            }

            foreach (var number in secondList)
            {
                sumSecondList += number;
            }

            if (sumFirstList == sumSecondList)
            {
                Console.WriteLine($"Yes. Sum: {sumFirstList}");
            }
            else
            {
                Console.WriteLine($"No. Diff: {Math.Abs(sumFirstList - sumSecondList)}");
            }
        }
    }
}
