#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STRING_LENGTH 11
#define MAX_COMMAND_LENGTH 4

// Linked List Node Struct
typedef struct node {
    char symbol[MAX_STRING_LENGTH];
    int count;
    struct node* next;
} Node;

/**
 * Command List and Function declaration
 * ins, del, fde, pst, prl, pcr, ppr, psu, end
 */
Node* ins(Node* head, const char* str);
Node* del(Node* head, const char* str);
Node* fde(Node* head, int val);
void pst(Node* head);
void prl(Node* head);
void pcr(Node* head, int v1, int v2);
void ppr(Node* head, const char* str);
void psu(Node* head, const char* str);
void freeList(Node* head);

// Main! Handles the command input and output prompts
int main() {
    Node* head = NULL;
    char command[MAX_COMMAND_LENGTH];
    char str[MAX_STRING_LENGTH];
    int val, v1, v2;

    printf("Enter the command: ");

    scanf("%3s", command);

    // Checks what command is given and scans the appropriate data
    while (strcmp(command, "end") != 0) {
        if (strcmp(command, "ins") == 0) {
            scanf("%10s", str);
        } else if (strcmp(command, "del") == 0) {
            scanf("%10s", str);
        } else if (strcmp(command, "fde") == 0) {
            scanf("%d", &val);
        } else if (strcmp(command, "pcr") == 0) {
            scanf("%d %d", &v1, &v2);
        } else if (strcmp(command, "ppr") == 0) {
            scanf("%10s", str);
        } else if (strcmp(command, "psu") == 0) {
            scanf("%10s", str);
        }
        // Handles the command executions
        if (strcmp(command, "ins") == 0) {
            head = ins(head, str);
        } else if (strcmp(command, "del") == 0) {
            head = del(head, str);
        } else if (strcmp(command, "fde") == 0) {
            head = fde(head, val);
        } else if (strcmp(command, "pst") == 0) {
            pst(head);
        } else if (strcmp(command, "prl") == 0) {
            prl(head);
        } else if (strcmp(command, "pcr") == 0) {
            pcr(head, v1, v2);
        } else if (strcmp(command, "ppr") == 0) {
            ppr(head, str);
        } else if (strcmp(command, "psu") == 0) {
            psu(head, str);
        }

        printf("Enter the command: ");

        scanf("%3s", command);
    }
    // Empties the list of all data before ending the program
    freeList(head);

    return 0;
}

// Insert function
Node* ins(Node* head, const char* str) {
    Node* current = head;
    Node* prev = NULL;

    while (current != NULL) {
        if (strcmp(current->symbol, str) == 0) {
            current->count++;
            // Move node to check decremental order
            if (prev != NULL && current->count > prev->count) {
                prev->next = current->next;
                Node* temp = head;
                Node* tempPrev = NULL;
                // Uses temporary node pointers to traverse the list.
                while (temp != NULL && temp->count >= current->count) {
                    tempPrev = temp;
                    temp = temp->next;
                }
                if (tempPrev == NULL) {
                    current->next = head;
                    return current;
                } else {
                    current->next = temp;
                    tempPrev->next = current;
                    return head;
                }
            }
            return head;
        }
        prev = current;
        current = current->next;
    }

    // If the node isnt found, allocates memory for a new one
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        printf("MEMORY NOT ALLOCATED: EXITING PROGRAM\n");
        exit(1);
    }
    // Assigns and initializes the variables for 
    strcpy(newNode->symbol, str);
    newNode->count = 1;
    newNode->next = NULL;

    if (head == NULL) {
        return newNode;
    } else {
        // Assigns the new node at the head of the list
        Node* temp = head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
        return head;
    }
}

// Delete Function
Node* del(Node* head, const char* str) {
    Node* current = head;
    Node* prev = NULL;
// Linked List loop for traversal
    while (current != NULL) {
        // Checks if the current nodes symbol is the given symbol and decrements if true
        if (strcmp(current->symbol, str) == 0) {
            current->count--;
            // Deletes the node if it has count 0
            if (current->count == 0) {
              
                if (prev == NULL) {
                    head = current->next;
                } else {
                    prev->next = current->next;
                }
                free(current);
                return head;
            } else {
                // Reorganizes the list in the correct order.
                Node* temp = head;
                Node* tempPrev = NULL;
                while (temp != NULL && temp->count >= current->count) {
                    if (temp == current) {
                        break; 
                    }
                    tempPrev = temp;
                    temp = temp->next;
                }
                if (tempPrev != NULL) {
                    if (current != head) {
                        prev->next = current->next;
                        current->next = temp;
                        if (current == head) {
                            head = current;
                        } else {
                            tempPrev->next = current;
                        }
                    }
                }
                return head;
            }
        }
        prev = current;
        current = current->next;
    }
    return head;
}

// Forced Delete Function
Node* fde(Node* head, int val) {
    Node* current = head;
    Node* prev = NULL;
    Node* next;
    // Checks if the current node is less than the value given and deletes if true
    while (current != NULL) {
        next = current->next;
        if (current->count <= val) {
            if (prev == NULL) {
                head = next;
            } else {
                prev->next = next;
            }
            free(current);
        } else {
            prev = current;
        }
        current = next;
    }
    return head;
}

// Print Statistics Function
void pst(Node* head) {
    if (head == NULL) {
        printf("The list is empty\n");
    } else {
        // Initializing variables for statistics
        int count = 0;
        int maxCount = head->count;
        int minCount = head->count;
        float sum = 0;
        // Linked List traversal
        Node* current = head;
        while (current != NULL) {
            count++;
            // Checks if the current node is either max or min count and assigns the variables if true.
            if (current->count > maxCount) {
                maxCount = current->count;
            }
            if (current->count < minCount) {
                minCount = current->count;
            }
            // Adds to the sum and increments the list
            sum += current->count;
            current = current->next;
        }
        // Print statements for outputting statistics.
        printf("%d\n", count);
        printf("%d\n", maxCount);
        printf("%d\n", minCount);
        // Contains logic to calculate average
        printf("%.2f\n", sum / count);
    }
}

// Print List Function
void prl(Node* head) {
    // If statement to check if the list is empty and to produce a error statement
    if (head == NULL) {
        printf("The list is empty\n");
    } else {
        // Initialize current pointer and check if the list has reached the end
        Node* current = head;
        while (current != NULL) {
            // Prints the node and traverses to the next Node
            printf("%s %d\n", current->symbol, current->count);
            current = current->next;
        }
    }
}

// Print Using Count Range Function
void pcr(Node* head, int v1, int v2) {
    if (head == NULL) {
        printf("The list is empty\n");
    } else {
        // Checks if the node is in the count range and prints if true
        Node* current = head;
        while (current != NULL) {
            if (current->count >= v1 && current->count <= v2) {
                printf("%s %d\n", current->symbol, current->count);
            }
            current = current->next;
        }
    }
}

// Print Prefix Function
void ppr(Node* head, const char* str) {
    if (head == NULL) {
        printf("The list is empty\n");
    } else {
        Node* current = head;
        while (current != NULL) {
            // Compares the beginning of the symbol to the given prefix and prints if true
            if (strncmp(current->symbol, str, strlen(str)) == 0) {
                printf("%s %d\n", current->symbol, current->count);
            }
            current = current->next;
        }
    }
}

// Print Suffix Function
void psu(Node* head, const char* str) {
    if (head == NULL) {
        printf("The list is empty\n");
    } else {
        Node* current = head;
        while (current != NULL) {
            // Compares the end of the symbol to the given prefix and prints if true
            int symbolLength = strlen(current->symbol);
            int suffixLength = strlen(str);
            if (symbolLength >= suffixLength &&
                strcmp(current->symbol + (symbolLength - suffixLength), str) == 0) {
                printf("%s %d\n", current->symbol, current->count);
            }
            current = current->next;
        }
    }
}

// End Function
void freeList(Node* head) {
    // Traverses the list and free each node's memory
    Node* current = head;
    Node* next;
    while (current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }
}

    
