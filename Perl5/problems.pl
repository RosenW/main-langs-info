sub insertion_sort {
    my (@nums) = @_;

    for my $i (1 .. scalar(@nums) - 1) {
        print("\n");
        print("NEXT NUM I: $i\n");
        print("NEXT NUM: $nums[$i]\n");
        print("PRINTING ARRAY:\n");
        for my $num (@nums) {
            print("$num, ");
        }
        print("\n");

        if ($nums[$i] < $nums[$i - 1]) {
            my $wrong_num = $nums[$i];
            splice(@nums, $i, 1); # deleting from old place

            my $found = 0;
            for my $j (reverse(0 .. $i - 1)) {
                if ($nums[$j] < $wrong_num) {
                    print("$nums[$j] is less than $wrong_num, switching pos\n");
                    $found = 1;
                    splice(@nums, $j + 1, 0, $wrong_num); # adding in new place
                    last;
                }
            }

            if (not $found) {
                print("$wrong_num is the smallest current num, putting as first el\n");
                unshift(@nums, $wrong_num);
            }


            print("PRINTING ARRAY AFTER MANIPULATION:\n");
            for my $num (@nums) {
                print("$num, ");
            }
            print("\n");
        }
    }

    return @nums;
}

my @nums = ( 1, 2, 5, 21, -1, -4, 23, 76, 11, 77, 99, 0, 123 );

for my $num (@nums) {
    print("$num, ");
}
print("\n");

my @sorted_nums = insertion_sort(@nums);

for my $num (@sorted_nums) {
    print("$num, ");
}
print("\n");
