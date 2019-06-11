package com.trilogyed;

public class ModulusAnimation {

    public static void main( String[] args ) throws Exception
    {
        for ( int i=0; i<80; i++ )
        {
            if ( i%16 == 0 )
                System.out.print(" .../_O_O_O_O_8<                 \r");
            else if ( i%8 == 1 )
                System.out.print("     .../_O_O_O_O_8<                \r");
            else if ( i%8 == 2 )
                System.out.print("        .../_O_O_O_O_8<              \r");
            else if ( i%8 == 3 )
                System.out.print("         .../_O_O_O_O_8<            \r");
            else if ( i%8 == 4 )
                System.out.print("           .../_O_O_O_O_8<          \r");
            else if ( i%8 == 5 )
                System.out.print("            .../_O_O_O_O_8<        \r");
            else if ( i%8 == 6 )
                System.out.print("              .../_O_O_O_O_8<      \r");
            else if ( i%8 == 7 )
                System.out.print("                   .../_O_O_O_O_8<    \r");
            else if ( i%8 == 8 )
                System.out.print("                     .../_O_O_O_O_8<  \r");
            else if ( i%8 == 9 )
                System.out.print("                   .../_O_O_O_O_8<    \r");
            else if ( i%8 == 10 )
                System.out.print("                 .../_O_O_O_O_8<      \r");
            else if ( i%8 == 11 )
                System.out.print("             .../_O_O_O_O_8<        \r");
            else if ( i%8 == 12 )
                System.out.print("            .../_O_O_O_O_8<          \r");
            else if ( i%8 == 13 )
                System.out.print("          .../_O_O_O_O_8<            \r");
            else if ( i%8 == 14 )
                System.out.print("         .../_O_O_O_O_8<              \r");
            else if ( i%8 == 15 )
                System.out.print("    .../_O_O_O_O_8<                \r");

            Thread.sleep(200);
        }

    }
}
