// Optimized
var cached_two_sum_pairs = {};

var twoSum = function(nums, target, skip_index) {    
    const hash_table = {};
    const plausible_duplets = [];
    
    for (let i = 0; i < nums.length; i++) {
        hash_table[nums[i]] = i;
    }
    
    for (let a = 0; a < nums.length; a++) {
        const hash_value = hash_table[(target - nums[a])];
        
        if (hash_value == a) { continue; }
        if (hash_value == skip_index) { continue; }
        if (a == skip_index) { continue; }
        
        if (hash_value != null) {
            plausible_duplets.push([nums[a], nums[hash_value]]);
        }
    }
    
    cached_two_sum_pairs[target] = true;
    return plausible_duplets;
};

var threeSum = function(nums) {
    nums = nums.sort((a, b) => { a - b });
    cached_two_sum_pairs = {};
    const plausible_triplets = [];
    
    for (let a = 0; a < nums.length; a++) {
        if (cached_two_sum_pairs[nums[a]]) {
            continue;
        }
        cached_two_sum_pairs[nums[a]] = true;
        
        two_sum_result = twoSum(nums, -nums[a], a);

        if (two_sum_result.length) {
            let result_triplets = [];
            for (let b = 0; b < two_sum_result.length; b++) {
                result_triplets.push([nums[a], two_sum_result[b][0], two_sum_result[b][1]]);
            }
            
            for (let c = 0; c < result_triplets.length; c++) {
                let is_duplicate = false;
                for (let d = 0; d < plausible_triplets.length; d++) {
                    if (plausible_triplets[d].sort().join(',') === result_triplets[c].sort().join(',')) {
                        is_duplicate = true; 
                    }
                }

                if (!is_duplicate) {
                    plausible_triplets.push(result_triplets[c]);
                }
            }
        }
    }
    
    return plausible_triplets;
};

var trap_old = function(height) {
    let water = 0;
    let previous_height_cache = -1;
    let previous_height_water_cache = 0;
    
    let left_highest = -1;
    
    for (let a = 0; a < height.length; a++) {
        let current_height = height[a];
        let right_highest = current_height;
    
        if (current_height > left_highest) {
            left_highest = current_height;
            continue;
        }
        
        if (current_height === previous_height_cache) {
            water += previous_height_water_cache;
            continue;
        }
        
        for (let right_index = a; right_index < height.length; right_index++) {
            if (height[right_index] > right_highest) {
                right_highest = height[right_index];
            }
        }
        
        let new_water = Math.min(right_highest, left_highest) - current_height;
        
        previous_height_cache = current_height;
        previous_height_water_cache = new_water;
        water += new_water;
    }
    
    return water;
};

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    let water = 0;
    let previous_height_cache = -1;
    let previous_height_water_cache = 0;
    
    let left_highest = -1;
    
    for (let a = 0; a < height.length; a++) {
        let current_height = height[a];
        let right_highest = current_height;
     
        if (current_height === previous_height_cache) {
            water += previous_height_water_cache;
            continue;
        }
        
        previous_height_cache = current_height;
        
        if (current_height > left_highest) {
            left_highest = current_height;
            continue;
        }
        
        for (let right_index = a; right_index < height.length; right_index++) {
            if (height[right_index] > right_highest) {
                right_highest = height[right_index];
            }
        }
        
        let new_water = Math.min(right_highest, left_highest) - current_height;
        
        previous_height_water_cache = new_water;
        water += new_water;
    }
    
    return water;
};

var findMedianSortedArrays = function(nums1, nums2) {
    let sum = 0;
    let merged_arr = [];
    let first_arr_index = 0;
    let second_arr_index = 0;
    
    for (let i = 0; i < nums1.length + nums2.length; i++) {
        
        
        if (
               second_arr_index == nums2.length
            || nums1[first_arr_index] <= nums2[second_arr_index]
        ) {
            merged_arr.push(nums1[first_arr_index]);
            first_arr_index++;
        } else {
            merged_arr.push(nums2[second_arr_index]);
            second_arr_index++;
        }
    }
    
    if ((nums1.length + nums2.length) % 2 == 0) {
        return (merged_arr[merged_arr.length / 2] + merged_arr[(merged_arr.length / 2) - 1]) / 2
    } else {
        return merged_arr[Math.floor(merged_arr.length / 2)]
    }
};

var nextPermutation = function(nums) {
    for (let i = nums.length - 1; i >= 0; i--) {
        let previous_element = i === 0 ? nums[nums.length - 1] : nums[i-1];
        
        if (nums[i] > previous_element) {
            console.log(nums[i] + ' is bigger than previous. changing.');
        console.log('Before change: ' + JSON.stringify(nums));
            let replacement = nums[i];
            nums[i] = previous_element;
            nums[i-1] = replacement;
        console.log('After change: ' + JSON.stringify(nums));
            break;
        } 
    }

    console.log('After permutation: ' + JSON.stringify(nums));
};

var nextPermutationOld = function(nums) {
    let sorted_nums = nums.sort();
    let num_hash = {};
    let permutations = [];
    
    let permute = function (arr, result = []) {
        if (arr.length === 0) {
            permutations.push(result);
        } else {
            for (let i = 0; i < arr.length; i++) {
                let new_arr = arr.slice();
                let next = new_arr.splice(i, 1);
                
                permute(new_arr.slice(), result.concat(next))
            }
        }
    }

    permute(nums);
    console.log(JSON.stringify(permutations));
};

var nextPermutation = function(nums) {
    let sorted_nums = nums.slice().sort();
    let num_hash = {};
    let permutations = [];
    let is_next_perm = false;
    let permutation_found = false;
    let previous_permutations = [];
    
    let permute = function (arr, result = []) {
        if (arr.length === 0) {
            current_permutation = result.join(',');
            let skip = false;

            for (let k = 0; k < previous_permutations.length; k++) {
                if (previous_permutations[k] === current_permutation) {
                    skip = true;
                }
            }

            if (!skip) {
                permutations.push(result);
                previous_permutations.push(current_permutation);

                if (is_next_perm) {
                    for (let j = 0; j < nums.length; j++) {
                        nums[j] = result[j];
                    }

                    permutation_found = true;
                }

                if (nums.join(',') === result.join(',')) {
                    is_next_perm = true;
                }
            }
        } else {
            for (let i = 0; i < arr.length; i++) {
                let new_arr = arr.slice();
                let next = new_arr.splice(i, 1);
                
                if (!permutation_found) {
                    permute(new_arr.slice(), result.concat(next));
                }
            }
        }
    }

    permute(sorted_nums);
    console.log(JSON.stringify(permutations));
    
    if (is_next_perm && !permutation_found) {
        nums.sort();
    }
};


// FUNCS WORKING PROPERLY 

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    const result_positions = [-1, -1];
    const start_pos_idx = 0;
    const end_pos_idx = 1;
    
    let number_found = false;
    let target_idx = -1;
    
    let start_idx = 0;
    let end_idx = nums.length - 1;
    let mid_idx = 0;
    
    // 0, 1, 4, 5, 6; T = 3;
    while (!number_found) {
        if (
               start_idx === end_idx
            && start_idx === mid_idx
            && nums[mid_idx] !== target
        ) {
            break;
        }
        
        mid_idx = Math.floor((start_idx + end_idx) / 2); // (0 + 10) / 2 = 5; (0 + 3) / 2 = 1
        
        if (mid_idx === start_idx) {
            if (nums[end_idx] === target) {
                target_idx = end_idx;
                number_found = true;
            } else if (nums[start_idx] === target) {
                target_idx = start_idx;
                number_found = true;
            } else {
                break;
            }
        }
        
        if (nums[mid_idx] === target) {
            target_idx = mid_idx;
            number_found = true;
        } else if (nums[mid_idx] > target) {
            end_idx = mid_idx;
        } else {
            start_idx = mid_idx;
        }
    }
    
    if (number_found) {
        result_positions[start_pos_idx] = target_idx;
        result_positions[end_pos_idx]   = target_idx;
        let start_idx_found = false;
        let end_idx_found = false;
        for (let i = 0; i < nums.length; i++) {
            if (start_idx_found && end_idx_found) {
                break;
            }
            
            if (nums[result_positions[start_pos_idx] - 1] === target && !start_idx_found) {
                result_positions[start_pos_idx]--;
            } else {
                start_idx_found = true;
            }

            if (nums[result_positions[end_pos_idx] + 1] === target && !end_idx_found) {
                result_positions[end_pos_idx]++;
            } else {
                end_idx_found = true;
            }
        }
    }
    
    return result_positions;
};

    
var coinChange = function(coins, amount) {    
    const dfs = function (current_amount = 0, coins_used = 0) {
        let result = -1;
        coins_used++;
        
        for (let i = 0; i < coins.length; i++) {
            let new_value = coins[i] + current_amount;
            let node_result;
            
            if (new_value === amount) { // if new node equals target result is coins used
                node_result = coins_used;
            }
            
            if (new_value > amount) { // if new node bigger than target, result is -1
                node_result = -1;
            }
            
            if (new_value > amount) { // if new node less than target, result is the result of the new node
                node_result = dfs(new_value, coins_used);
            }
            
            if (node_result !== -1) { // check if node result is a better solution
                if (
                       result === -1
                    || node_result < result
                ) {
                    result = node_result;
                    continue;
                }
            }
        }
        
        return result;
    }
    
    let solution = dfs();
    
    return solution;
};


/**
 * @param {number} target
 * @return {number}
 */
let solution = null;
let nodes = [];
let cache = {};
const super_magic_number = 50;

const bfs = function(target) {
    if (nodes.length === 0) {
        return;
    }

    const node = nodes.splice(0, 1)[0];

    // Calc pos, sp, st
    if (node["is_a"] === null) {
        // Do nothing.
    } else if (node["is_a"] === true) {
        // pos += speed;
        // speed *= 2;
        node["pos"] += node["sp"];
        node["sp"] *= 2;
    } else {
        // speed > 0 ? -1 : 1;
        node["sp"] = node["sp"] > 0 ? -1 : 1;
    }

    // Check cache a) upd sol, cache, b) upd cache, c) discard, c1) cache value always better, c2) solution found
    let is_new_potential_solution = true;

    if (node["pos"] == target) {
        is_new_potential_solution = false;
        solution = node["st"];
        nodes = [];
    } else {
        if (cache.hasOwnProperty(node["pos"])) {
            for (let i = 0; i < cache[node["pos"]].length; i++) {
                if (cache[node["pos"]][i]["sp"] === node["sp"]) { // if it can arrive at current pos with same sp then discard this node
                    is_new_potential_solution = false;
                    break;   
                }
            }

            if (is_new_potential_solution) {
                cache[node["pos"]].push(node);    
            }
        } else {
            cache[node["pos"]] = [ node ];
        }
    }

    // quit if solution found or add new nodes
    if (solution !== null) {
        return;
    }

    
    if (is_new_potential_solution) {
        //node["st"]++;
        //nodes.push({ "pos": node["pos"], "sp": node["sp"], "st": node["st"], "is_a": true});
        //nodes.push({ "pos": node["pos"], "sp": node["sp"], "st": node["st"], "is_a": false});

        node["st"]++;
        if (target > super_magic_number && node["pos"] < target / 2) { // Giga brain optimization
            nodes.push({ "pos": node["pos"], "sp": node["sp"], "st": node["st"], "is_a": true});
        } else {
            nodes.push({ "pos": node["pos"], "sp": node["sp"], "st": node["st"], "is_a": true});
            nodes.push({ "pos": node["pos"], "sp": node["sp"], "st": node["st"], "is_a": false});    
        }
    }
}

var racecar = function(target) {
    const starting_pos = 0;
    const starting_speed = 1;
    const starting_steps = 0;
    
    solution = null;
    nodes = [ { "pos": starting_pos, "sp": starting_speed, "st": starting_steps, "is_a": null } ];
    cache = {};

    while(solution === null) {
        bfs(target);
    }        
        
    return solution;
};

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    const visited_spots = {};
    let island_count = 0;
    
    for (let y = 0; y < grid.length; y++) {
        for (let x = 0; x < grid[y].length; x++) {
            if (grid[y][x] === "1") {
                const current_spot_key = [y, x].join(",");
                if (visited_spots[current_spot_key]) {
                    continue;
                } else {
                    island_count++;
                    
                    let connected_nodes = [ { "y": y, "x": x } ];
                    while (connected_nodes.length > 0) {
                        let current_node = connected_nodes.splice(0, 1)[0];
                        let current_node_key = [current_node["y"], current_node["x"]].join(",");
                                    
                        if (visited_spots[ current_node_key ]) {
                            continue;
                        } else {
                            visited_spots[ current_node_key ] = true;
                        }
 
                        if (grid[current_node["y"]+1] && grid[current_node["y"]+1][current_node["x"]] && grid[current_node["y"]+1][current_node["x"]] === "1") {
                            connected_nodes.push({ "y": current_node["y"] + 1, "x": current_node["x"] })
                        }
                        if (grid[current_node["y"]-1] && grid[current_node["y"]-1][current_node["x"]] && grid[current_node["y"]-1][current_node["x"]] === "1") {
                            connected_nodes.push({ "y": current_node["y"] - 1, "x": current_node["x"] })
                        }
                        if (grid[current_node["y"]][current_node["x"]+1] && grid[current_node["y"]][current_node["x"]+1] === "1") {
                            connected_nodes.push({ "y": current_node["y"], "x": current_node["x"] + 1 })
                        }
                        if (grid[current_node["y"]][current_node["x"] - 1] && grid[current_node["y"]][current_node["x"] - 1] === "1") {
                            connected_nodes.push({ "y": current_node["y"], "x": current_node["x"] - 1 })
                        }
                    }
                }
            } else {
                continue;
            }
        }   
    }
    
    return island_count;
};

/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    let new_intervals = [];
    let intervals_length = intervals.length;
    
    for (let i = 0; i < intervals_length; i++) {
        let interval = intervals.splice(0,1)[0];
        let i_start = interval[0];
        let i_end = interval[1];
        
        let is_overlapping = false;
        for (let j = 0; j < new_intervals.length; j++) {
            let ni_start = new_intervals[j][0];
            let ni_end = new_intervals[j][1];
            
            if (i_start <= ni_end) {
                is_overlapping = true;
                
                let lowest_start = i_start < ni_start ? i_start : ni_start;
                let highest_end = i_end > ni_end ? i_end : ni_end;
                
                new_intervals[j][0] = lowest_start;
                new_intervals[j][1] = highest_end;
                break;
            }
        }
        
        if (!is_overlapping) {
            new_intervals.push(interval);
        }
    }
    
    return new_intervals;
};


// Definition for singly-linked list.
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    let merged_linked_list = [];
    let merged_idx = 0;
    let lists_depleted = false;
    
    while (!lists_depleted) {
        let lowest = null;
        let lowest_arr_idx = null;
        
        for (let i = 0; i < lists.length; i++) {
            let list_element = lists[i];
            let list_value;
            
            if (list_element != null) {
                list_value = list_element.val;
            } else {
                continue;
            }

            if (lowest == null || list_value < lowest) {
                lowest = list_value;
                lowest_arr_idx = i;
            }
        }
        
        let new_node = new ListNode(lowest, undefined);
        if (lowest != null) {
            lists[lowest_arr_idx] = lists[lowest_arr_idx].next;
            
            if (merged_idx === 0) {
                merged_linked_list.push(new_node);
            } else {
                merged_linked_list[(merged_idx - 1)].next = new_node;
            }

            merged_idx++;
        } else {
            lists_depleted = true;
        }
    }
    
    return merged_linked_list;
};

/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {
    let deconstructed_nums = [];
    
    for (let i = 0; i < nums.length; i++) {
        // let num_as_str = nums[i].toString();
        // for (let j = 0; j < num_as_str.length; j++) {
        //   deconstructed_nums.push(parseInt(num_as_str.charAt(j)));
        // }
        
        deconstructed_nums.push(nums[i].toString());
    }
    
    return deconstructed_nums.sort((a, b) => {
        let first = parseInt(a + b);
        let second = parseInt(b + a);
        return first > second ? -1 : 1;
    }).join("");
};

/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    let new_str = "";
    let balance_counter = 0;
    
    let open_arr = [];
    let close_arr = [];
    let remove_hash = {};
    
    for (let i = 0; i < s.length; i++) {
        let cchar = s.charAt(i);
        if (cchar === "(") {
            open_arr.unshift(i);
            balance_counter++;
        } else if (cchar === ")") {
            if (balance_counter === 0) {
                remove_hash[i] = true;
            } else {
                close_arr.unshift(i);
                balance_counter--;    
            }
        } else {
            continue;
        }
    }
    
    let c_idx = 0;
    while (balance_counter > 0) {
        remove_hash[open_arr[c_idx]] = true;
        balance_counter--;
        c_idx++;
    }
    
    c_idx = 0;
    while (balance_counter < 0) {
        remove_hash[close_arr[c_idx]] = true;
        balance_counter++;
        c_idx++;
    }
    
    
    for (let i = 0; i < s.length; i++) {
        if (!remove_hash[i]) {
            new_str = new_str + s.charAt(i);
        }
    }
    
    return new_str;
};

/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    let sorted = nums.sort();
    let missing = nums.length;
    for (let i = 0; i < sorted.length; i++) {
        if (sorted[i] != i) {
            missing = i;
            break;
        }
    }
    
    return missing;
};

