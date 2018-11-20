using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Note_Statistics
{
    class NoteStatistics
    {
        static void Main(string[] args)
        {
            var notesList = new List<string> { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };
            var frequency = new List<double> { 261.63, 277.18, 293.66, 311.13, 329.63, 349.23, 369.99, 392.00, 415.30, 440.00, 466.16, 493.88 };

            var input = Console.ReadLine().Split().Select(double.Parse).ToList();

            var result = new List<string>();

            foreach (var i in input)
            {
                var frequencyIndex = frequency.IndexOf(i);
                var note = notesList[frequencyIndex];

                result.Add(note);
            }

            Console.WriteLine("Notes: {0}", string.Join(" ", result));

            var naturals = new List<string>();
            var sharps = new List<string>();

            for (int i = 0; i < result.Count; i++)
            {
                if (result[i].Contains("#"))
                {
                    sharps.Add(result[i]);
                }
                else
                {
                    naturals.Add(result[i]);
                }
            }

            Console.WriteLine("Naturals: {0}", string.Join(", ", naturals));
            Console.WriteLine("Sharps: {0}", string.Join(", ", sharps));

            double sumNaturals = GetNoteSum(frequency, notesList, naturals);
            double sumSharps = GetNoteSum(frequency, notesList, sharps);

            Console.WriteLine("Naturals sum: {0}",  sumNaturals);
            Console.WriteLine("Sharps sum: {0}", sumSharps);


        }

        static double GetNoteSum(List<double> allFrequency, List<string> allNotes, List<string> notes)
        {
            var noteSum = 0.0;
            foreach (var i in notes)
            {
                var notesInedex = allNotes.IndexOf(i);
                var frequencies = allFrequency[notesInedex];

                noteSum += frequencies;
            }

            return noteSum;
        }
    }
}
