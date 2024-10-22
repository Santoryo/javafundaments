class Quadratic
{
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        float delta = b * b - 4 * a * c;
        
        if (delta < 0)
        {
            System.out.println("No real roots");
        } else
        {
            float x1 = (float) (-b + Math.sqrt(delta)) / (2 * a);
            float x2 = (float) (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Roots are " + x1 + " and " + x2);
        }
    }
}