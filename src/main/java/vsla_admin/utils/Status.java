package vsla_admin.utils;

public enum Status {
    ACTIVE,
    PENDING,
    SUSPENDED,
    BANNED;

    public static Status getEnum(String roleName) {
        return Status.valueOf(roleName.toUpperCase());
    }
}
